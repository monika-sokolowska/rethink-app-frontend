import "./HouseholdFootprint.css";
import MainFootprint from "./MainFootprint/MainFootprint";
import { useSelector } from "react-redux";

const HouseholdFootprint = () => {
  const { householdFootprint } = useSelector(
    (store) => store.householdFootprint
  );

  return (
    <section className="household-footprint">
      <MainFootprint footprint={householdFootprint} />
      <button>Count</button>
    </section>
  );
};
export default HouseholdFootprint;
