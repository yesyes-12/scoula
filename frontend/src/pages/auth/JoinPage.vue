<script setup>
import authApi from "@/api/authApi";
import { reactive, ref } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();
const avatar = ref(null);
const checkError = ref("");

const member = reactive({
  username: "hong",
  email: "hong@gmail.com",
  password: "12",
  password2: "12",
  avatar: "null",
});

const disableSubmit = ref(true);

const checkUsername = async () => {
  if (!member.username) {
    return alert("사용자 id 입력");
  }

  disableSubmit.value = await authApi.checkUsername(member.username);
  console.log(disableSubmit.value, typeof disableSubmit.value);
  checkError.value = disableSubmit.value
    ? "이미 사용중인 ID입니다."
    : "사용가능한 ID입니다.";
};

const changeUsername = () => {
  disableSubmit.value = true;
  if (member.username) {
    checkError.value = "ID 중복 체크를 확인해주세요";
  } else {
    checkError.value = "";
  }
};

const join = async () => {
  if (member.password != member.password2) {
    return alert("비밀번호가 일치하지 않아요");
  }

  if (avatar.value.files.length > 0) {
    member.avatar = avatar.value.files[0];
  }

  try {
    await authApi.create(member);
    router.push({ name: "home" });
  } catch (e) {
    console.error(e);
  }
};
</script>

<template>
  <div class="mt-5 mx-auto" style="width: 500px">
    <h1 class="my-5">
      <i class="fa-solid fa-user-plus"></i>
      회원 가입
    </h1>
  </div>

  <form @submit.prevent="join">
    <div class="mb-3 mt-3">
      <label for="usename" class="form-label">
        <i class="fa-solid fa-user"></i>
        사용자ID:
        <button
          type="button"
          class="btn btn-success btn-sm py-0 me-2"
          @click="checkUsername"
        >
          ID 중복 확인
        </button>
        <span :class="disableSubmit ? 'text-primary' : 'text-danger'">{{
          checkError
        }}</span>
      </label>
      <input
        type="text"
        class="form-control"
        placeholder="사용자 ID"
        id="username"
        @input="changeUsername"
        v-model="member.username"
      />
    </div>

    <div>
      <label for="avatar" class="form-label">
        <i class="fa-solid fa-user-astronaut"></i> 아바타이미지:
      </label>
      <input
        type="file"
        class="form-control"
        id="avatar"
        ref="avatar"
        accept="image/png,  image/jpeg"
      />
    </div>

    <div class="mb-3 mt-3">
      <label for="email" class="form-label">
        <i class="fa-solid fa-envelope"></i>
        email
      </label>
      <input
        type="email"
        class="form-control"
        id="email"
        placeholder="Email"
        v-model="member.email"
      />
    </div>

    <div class="mb-3">
      <label for="password" class="form-label">
        <i class="fa-solid fa-lock"></i>
        비밀번호:
      </label>
      <input
        type="password"
        class="form-control"
        id="password"
        placeholder="비밀번호"
        v-model="member.password2"
      />
    </div>

    <button
      type="sumbit"
      class="btn btn-primary mt-4"
      :disabled="disableSubmit"
    >
      <i class="fa-solid fa-user-plus"></i>
      확인
    </button>
  </form>
</template>
