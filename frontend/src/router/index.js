// 기본 라우팅
import { createRouter, createWebHistory } from "vue-router";
import Homepage from "@/pages/Homepage.vue";
import authRoutes from "./auth";
import boardRoutes from "./board";
import travelRoutes from "./travel";
import galleryRoutes from "./gallery";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: "/", name: "home", component: Homepage },
    ...authRoutes,
    ...boardRoutes,
    ...travelRoutes,
    ...galleryRoutes,
  ],
});

export default router;
