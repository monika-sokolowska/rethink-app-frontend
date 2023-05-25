import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { toast } from "react-toastify";
import { getAllArticlesThunk } from "./allArticlesThunk";

const initialState = {
  isLoading: true,
  articles: [],
};

export const getAllArticles = createAsyncThunk(
  "allArticles/getAllArticles",
  getAllArticlesThunk
);

const allArticlesSlice = createSlice({
  name: "allArticles",
  initialState,
  reducers: {
    showLoading: (state) => {
      state.isLoading = true;
    },
    hideLoading: (state) => {
      state.isLoading = false;
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(getAllArticles.pending, (state) => {
        state.isLoading = true;
      })
      .addCase(getAllArticles.fulfilled, (state, { payload }) => {
        state.isLoading = false;
        state.articles = payload;
      })
      .addCase(getAllArticles.rejected, (state, { payload }) => {
        state.isLoading = false;
        toast.error(payload);
      });
  },
});

export const { showLoading, hideLoading } = allArticlesSlice.actions;

export default allArticlesSlice.reducer;
