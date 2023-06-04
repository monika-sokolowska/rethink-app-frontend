import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { toast } from "react-toastify";
import { getFootprintThunk, addFootprintThunk } from "./dailyFootprintThunk";

const initialState = {
  isLoading: false,
  transport: [],
  food: [],
  other: [],
};

export const getTransportFootprint = createAsyncThunk(
  "user/getTransportFootprint",
  async (_, thunkAPI) => {
    return getFootprintThunk(`/footprint/transport`, thunkAPI);
  }
);

export const getFoodFootprint = createAsyncThunk(
  "user/getFoodFootprint",
  async (_, thunkAPI) => {
    return getFootprintThunk(`/footprint/food`, thunkAPI);
  }
);

export const getOtherFootprint = createAsyncThunk(
  "user/getOtherFootprint",
  async (_, thunkAPI) => {
    return getFootprintThunk(`/footprint/other`, thunkAPI);
  }
);

export const addTransportFootprint = createAsyncThunk(
  "user/addTransportFootprint",
  async (footprint, thunkAPI) => {
    const result = await addFootprintThunk(
      `/footprint/add/transport`,
      footprint
    );
    thunkAPI.dispatch(getTransportFootprint());
    return result;
  }
);

export const addFoodFootprint = createAsyncThunk(
  "user/addFoodFootprint",
  async (footprint, thunkAPI) => {
    const result = await addFootprintThunk(`/footprint/add/food`, footprint);
    thunkAPI.dispatch(getFoodFootprint());
    return result;
  }
);

export const addOtherFootprint = createAsyncThunk(
  "user/addOtherFootprint",
  async (footprint, thunkAPI) => {
    thunkAPI.dispatch(getOtherFootprint());
    return addFootprintThunk(`/footprint/add/other`, footprint);
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
