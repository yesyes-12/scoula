import api from "@/api";
const BASE_URL = "/api/member";
const headers = { "Content-Type": "multipart/form-data" };

export default {
  // username 중복 체크, true 중복, false 사용가능
  async checkUsername(username) {
    const data = await api.get(`${BASE_URL}/checkusername/${username}`);
    console.log("AUTH GET CHECKUSERNAME", data);
    return data;
  },

  async create(member) {
    const formData = new FormData();
    formData.append("username", member.username);
    formData.append("email", member.email);
    formData.append("password", member.password);

    if (member.avatar) {
      formData.append("avatar", member.avatar);
    }

    const data = await api.post(BASE_URL, formData, headers);

    console.log("data");
    return data;
  },

  async update(member) {
    const formData = new FormData();
    formData.append("username", member.username);
    formData.append("password", member.password);
    formData.append("email", member.email);

    if (member.avatar) {
      formData.append("avatar", member.avatar);
    }

    const { data } = await api.put(
      `${BASE_URL}/${member.username}`,
      formData,
      headers,
    );
    return data;
  },
};
