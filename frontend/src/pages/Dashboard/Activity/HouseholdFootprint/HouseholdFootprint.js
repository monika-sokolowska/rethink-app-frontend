import "./HouseholdFootprint.css";
import MainFootprint from "./MainFootprint/MainFootprint";

const HouseholdFootprint = () => {
  return (
    <section className="household-footprint">
      <MainFootprint />
      <button>Count</button>
    </section>
  );
};
export default HouseholdFootprint;
