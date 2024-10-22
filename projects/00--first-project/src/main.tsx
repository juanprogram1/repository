import ReactDOM from "react-dom/client";
// import React from "react";
import { App } from "./App";

import "./css/index.css";

const root = ReactDOM.createRoot(
  document.getElementById("root") as HTMLDivElement
);

root.render(
  <section className="App">
    <App userName="Juan" age={30} nick="Popote" />
    <App userName="Jose" age={20} nick="azulejo" />
  </section>
);
