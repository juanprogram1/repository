import { AppProps } from "./describe";

function App(props: AppProps) {
  return (
    <div className="react">
      My nick is {props.nick} I'm {props.userName} and I'm {props.age} years
      old.
    </div>
  );
}

export { App };
