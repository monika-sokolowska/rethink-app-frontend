import { configureStore } from "@reduxjs/toolkit";
import userSlice from "./reducers/userSlice";
import goalsSlice from "./reducers/goalsSlice";
import allArticlesSlice from "./reducers/allArticlesSlice";
import dailyFootprintSlice from "./reducers/dailyFootprintSlice";

export const store = configureStore({
  reducer: {
    user: userSlice,
    articles: allArticlesSlice,
    goals: goalsSlice,
    footprint: dailyFootprintSlice,
  },
});
