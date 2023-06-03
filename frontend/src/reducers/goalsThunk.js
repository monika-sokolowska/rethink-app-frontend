import customFetch from "../utils/axios";

export const getGoalsThunk = async (url, thunkAPI) => {
  try {
    const resp = await customFetch.get(url);
    return resp.data;
  } catch (error) {
    return thunkAPI.rejectWithValue(error.response.data.msg);
  }
};

export const addGoalThunk = async (url, goal) => {
  try {
    const resp = await customFetch.post(url, goal);
    return resp.data;
  } catch (error) {}
};
