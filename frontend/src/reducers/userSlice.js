import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { toast } from "react-toastify";
import {
  addUserToLocalStorage,
  getUserFromLocalStorage,
  removeUserFromLocalStorage,
} from "../utils/localStorage";
import {
  loginUserThunk,
  clearStoreThunk,
  changeMainGoalThunk,
  getUserThunk,
} from "./userThunk";

const initialState = {
  isLoading: false,
  user: getUserFromLocalStorage(),
};

export const loginUser = createAsyncThunk(
  "user/loginUser",
  async (user, thunkAPI) => {
    return loginUserThunk("/user/login", user, thunkAPI);
  }
);

export const changeMainGoal = createAsyncThunk(
  "user/changeMainGoal",
  async (data) => {
    const { userId, goal } = data;
    return changeMainGoalThunk(`/user/goal/change/${userId}`, goal);
  }
);

export const getUser = createAsyncThunk("user/getUser", async (userId) => {
  return getUserThunk(`/user/get/${userId}`);
});

export const clearStore = createAsyncThunk("user/clearStore", clearStoreThunk);
const userSlice = createSlice({
  name: "user",
  initialState,
  reducers: {
    logoutUser: (state, { payload }) => {
      state.user = null;
      removeUserFromLocalStorage();
      if (payload) {
        toast.success(payload);
      }
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(loginUser.pending, (state) => {
        state.isLoading = true;
      })
      .addCase(loginUser.fulfilled, (state, { payload }) => {
        const user = payload;
        console.log("payload", payload);
        state.isLoading = false;
        state.user = user;
        addUserToLocalStorage(user);
        toast.success(`Welcome ${user.name}`);
      })
      .addCase(loginUser.rejected, (state, { payload }) => {
        state.isLoading = false;
        toast.error(payload);
      })
      .addCase(clearStore.rejected, () => {
        toast.error("There was an error..");
      })
      .addCase(getUser.pending, (state) => {
        state.isLoading = true;
      })
      .addCase(getUser.fulfilled, (state, { payload }) => {
        const user = payload;
        state.isLoading = false;
        state.user = user;
        addUserToLocalStorage(user);
      })
      .addCase(getUser.rejected, (state, { payload }) => {
        state.isLoading = false;
        toast.error(payload);
      });
  },
});

export const { logoutUser } = userSlice.actions;
export default userSlice.reducer;
