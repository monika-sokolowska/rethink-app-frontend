import "./MyFootprint.css";
import ActivitySectionPart from "./ActivitySectionPart/ActivitySectionPart";

const MyFootprint = () => {
  return (
    <section className="my-footprint">
      <ActivitySectionPart label="Transport" />
      <ActivitySectionPart label="Food" />
      <ActivitySectionPart label="Other" />
    </section>
  );
};
export default MyFootprint;
