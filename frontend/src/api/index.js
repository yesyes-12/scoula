import router from "@/router";
import { useAuthStore } from "@/stores/auth";
import axios from "axios";

const instance = axios.create({
  timeout: 1000,
});

instance.interceptors.request.use(
  (config) => {
    const { getToken } = useAuthStore();
    const token = getToken;
    if (token) {
      config.headers["Authorization"] = `Bearer ${token}`;
      console.log(config.headers.Authorization);
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  },
);

instance.interceptors.response.use(
  (response) => {
    if (response.status === 200) {
      return response;
    }
    if (response.status === 404) {
      return Promise.reject("404: 페이지 없음" + response.request);
    }
    return response;
  },
  async (error) => {
    if (error.response?.status === 401) {
      const { logout } = useAuthStore();
      logout();
      router.push("/auth/login?error=login_requried");
      return Promise.reject({ error: "로그인이 필요한 서비스예요" });
    }
    return Promise.reject(error);
  },
);

export default instance;
