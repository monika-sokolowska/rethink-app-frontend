import SharedLayout from "./pages/Dashboard/SharedLayout";
import LoginPage from "./pages/LoginPage/LoginPage";
import RegisterPage from "./pages/RegisterPage/RegisterPage";
import FirstPage from "./pages/FirstPage/FirstPage";
import Stats from "./pages/Dashboard/Stats/Stats";
import Goals from "./pages/Dashboard/Goals/Goals";
import Activity from "./pages/Dashboard/Activity/Activity";
import MyFootprint from "./pages/Dashboard/Activity/MyFootprint/MyFootprint";
import HouseholdFootprint from "./pages/Dashboard/Activity/HouseholdFootprint/HouseholdFootprint";
import News from "./pages/Dashboard/News/News";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<FirstPage />}></Route>
        <Route path="/register" element={<RegisterPage />}></Route>
        <Route path="/login" element={<LoginPage />}></Route>
        <Route path="/home" element={<SharedLayout />}>
          <Route index element={<Stats />} />
          <Route path="/home/goals" element={<Goals />} />
          <Route path="/home/activity" element={<Activity />}>
            <Route index element={<MyFootprint />} />
            <Route
              path="/home/activity/household"
              element={<HouseholdFootprint />}
            />
          </Route>
          <Route path="/home/news" element={<News />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
