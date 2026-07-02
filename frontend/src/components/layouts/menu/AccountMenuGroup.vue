<script setup>
import { computed } from "vue";
import AccountMenuItem from "./AccountMenuItem.vue";
import LogoutMenuItem from "./LogoutMenuItem.vue";
import MenuItem from "./MenuItem.vue";
import config from "@/config";

const { login, join } = config.accountMenus;

const islogin = computed(() => false);
const username = computed(() => "");
</script>

<template>
  <ul class="navbar-nav ms-auto">
    <template v-if="islogin">
      <AccountMenuItem :username="username" />
      <LogoutMenuItem />
    </template>
    <template v-else>
      <MenuItem :menu="login" />
      <MenuItem :menu="join" />
    </template>
  </ul>
</template>
