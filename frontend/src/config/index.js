export default {
  title: "Scoula",
  subtitle: "KB Fullstack 학습(Vue+Spring)",
  menus: [
    {
      title: "게시판",
      url: "/board/list",
      icon: "fa-solid fa-paste",
    },
    {
      title: "여행",
      url: "/travel/list",
      icon: "fa-solid fa-plane-departure",
    },
    {
      title: "갤러리",
      url: "/gallery/list",
      icon: "fa-solid fa-images",
    },
  ],
  accountMenus: {
    login: {
      title: "로그인",
      url: "/auth/login",
      icon: "fa-solid fa-right-to-bracket",
    },
    join: {
      title: "회원가입",
      url: "/auth/join",
      icon: "fa-solid fa-user-plus",
    },
  },
};
