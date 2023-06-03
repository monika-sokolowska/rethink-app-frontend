import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { toast } from "react-toastify";
import { getFootprintThunk, addFootprintThunk } from "./dailyFootprintThunk";

const initialState = {
  isLoading: true,
  transport: [],
  food: [],
  other: [],
};

export const getTransportFootprint = createAsyncThunk(
  "user/getTransportFootprint",
  async (userId, thunkAPI) => {
    return getFootprintThunk(`/footprint/transport/${userId}`, thunkAPI);
  }
);

export const getFoodFootprint = createAsyncThunk(
  "user/getFoodFootprint",
  async (userId, thunkAPI) => {
    return getFootprintThunk(`/footprint/food/${userId}`, thunkAPI);
  }
);

export const getOtherFootprint = createAsyncThunk(
  "user/getOtherFootprint",
  async (userId, thunkAPI) => {
    return getFootprintThunk(`/footprint/other/${userId}`, thunkAPI);
  }
);

export const addTransportFootprint = createAsyncThunk(
  "user/addTransportFootprint",
  async (data) => {
    const { userId, addedFootprint } = data;
    return addFootprintThunk(
      `/footprint/add/transport/${userId}`,
      addedFootprint
    );
  }
);

export const addFoodFootprint = createAsyncThunk(
  "user/addFoodFootprint",
  async (data) => {
    const { userId, addedFootprint } = data;
    return addFootprintThunk(`/footprint/add/food/${userId}`, addedFootprint);
  }
);

export const addOtherFootprint = createAsyncThunk(
  "user/addFoodFootprint",
  async (data) => {
    const { userId, addedFootprint } = data;
    return addFootprintThunk(`/footprint/add/other/${userId}`, addedFootprint);
  }
);

const dailyFootprintSlice = createSlice({
  name: "dailyFootprint",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(getTransportFootprint.pending, (state, { payload }) => {
        state.isLoading = true;
      })
      .addCase(getTransportFootprint.fulfilled, (state, { payload }) => {
        state.isLoading = false;
        const transport = payload;
        state.transport = transport;
      })
      .addCase(getTransportFootprint.rejected, (state, { payload }) => {
        state.isLoading = false;
        toast.error(payload);
      })
      .addCase(getFoodFootprint.pending, (state, { payload }) => {
        state.isLoading = true;
      })
      .addCase(getFoodFootprint.fulfilled, (state, { payload }) => {
        state.isLoading = false;
        const food = payload;
        state.food = food;
      })
      .addCase(getFoodFootprint.rejected, (state, { payload }) => {
        state.isLoading = false;
        toast.error(payload);
      })
      .addCase(getOtherFootprint.pending, (state, { payload }) => {
        state.isLoading = true;
      })
      .addCase(getOtherFootprint.fulfilled, (state, { payload }) => {
        state.isLoading = false;
        const other = payload;
        state.other = other;
      })
      .addCase(getOtherFootprint.rejected, (state, { payload }) => {
        state.isLoading = false;
        toast.error(payload);
      });
  },
});

export default dailyFootprintSlice.reducer;
