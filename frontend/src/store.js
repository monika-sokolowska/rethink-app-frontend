import { configureStore } from "@reduxjs/toolkit";
import userSlice from "./reducers/userSlice";
import allArticlesSlice from "./reducers/allArticlesSlice";

export const store = configureStore({
  reducer: {
    user: userSlice,
    articles: allArticlesSlice,
  },
});
