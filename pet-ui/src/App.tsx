import React from 'react';
import './App.css';
import {HashRouter, Route, RouteComponentProps, Switch} from "react-router-dom";
import {AdoptionForm, AdoptionFormParams} from "./components/AdoptionForm";
import {PetTable} from "./components/PetTable";

function App() {

  const Form = ( { match }: RouteComponentProps<AdoptionFormParams>)  => {
    const id = parseInt(match.params.id);
    return <AdoptionForm type={match.params.type} id={id}/>;
  };

  const Table = () => {
    return <PetTable/>;
  };

  return (
    <div className="App">
      <HashRouter>
        <Switch>
          <Route path='/adopt/:type/:id' component={Form}/>
          <Route path='/' component={Table}/>
        </Switch>
      </HashRouter>
    </div>
  );
}

export default App;
