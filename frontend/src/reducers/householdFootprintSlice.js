import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { toast } from "react-toastify";
import {
  getHouseholdThunk,
  addHouseholdThunk,
} from "./householdFootprintThunk";

const initialState = {
  isLoading: false,
  householdFootprint: [],
};

export const getHouseholdFootprint = createAsyncThunk(
  "user/getHouseholdFootprint",
  async (userId, thunkAPI) => {
    return getHouseholdThunk(`/household/get/${userId}`, thunkAPI);
  }
);

export const addHouseholdFootprint = createAsyncThunk(
  "user/addHouseholdFootprint",
  async (data) => {
    const { userId, footprint } = data;
    return addHouseholdThunk(`/household/add/${userId}`, footprint);
  }
);

const householdFootprintSlice = createSlice({
  name: "dailyFootprint",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(getHouseholdFootprint.pending, (state, { payload }) => {
        state.isLoading = true;
      })
      .addCase(getHouseholdFootprint.fulfilled, (state, { payload }) => {
        state.isLoading = false;
        const transport = payload;
        state.transport = transport;
      })
      .addCase(getHouseholdFootprint.rejected, (state, { payload }) => {
        state.isLoading = false;
        toast.error(payload);
      });
  },
});

export default householdFootprintSlice.reducer;
