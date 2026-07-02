<script setup>
defineProps({ username: String });
</script>

<template>
  <li>
    <router-link class="nav-link" to="/auth/profile">
      <i class="fa-solid fa-user"></i>
      {{ username }}
    </router-link>
  </li>
</template>
