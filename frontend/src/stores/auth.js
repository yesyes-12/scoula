import { defineStore } from "pinia";
import { computed, ref } from "vue";
import axios from "axios";

const initState = {
  token: "",
  user: {
    username: "",
    email: "",
    roles: [],
  },
};

export const useAuthStore = defineStore("auth", () => {
  const state = ref({ ...initState });

  const isLogin = computed(() => !!state.value.user.username);
  const username = computed(() => state.value.user.username);
  const email = computed(() => state.value.user.email);

  const login = async (member) => {
    //state.value.token = "test token";
    // state.value.user = {
    //   username: member.username,
    //   email: member.username + "@test.com",
    // };

    const { data } = await axios.post("/api/auth/login", member);
    state.value = { ...data };

    localStorage.setItem("auth", JSON.stringify(state.value));
  };

  const logout = () => {
    localStorage.clear();
    state.value = { ...initState };
  };

  const getToken = () => state.value.token;

  const load = () => {
    const auth = localStorage.getItem("auth");
    if (auth != null) {
      state.value = JSON.parse(auth);
      console.log(state.value);
    }
  };

  const changeProfile = (member) => {
    state.value.user.email = member.email;
    localStorage.setItem("auth", JSON.stringify(state.value));
  };

  load();

  return { state, username, email, isLogin, login, logout, getToken };
});
