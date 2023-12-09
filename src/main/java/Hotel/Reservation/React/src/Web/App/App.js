import Top from "../Top/Top";
import './App.css';

import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import { Main , User , Hotel , Admin , Login} from './Pages';


function App() {
    return (
        <Router>
            <div className="App">
                <Top/>
                <Switch>
                <div className="Page">
                    <Route exact path="/">
                        <Main/>
                    </Route>
                    <Route path="/User">
                        <User/>
                    </Route>
                    <Route path="/Hotel">
                        <Hotel/>
                    </Route>
                    <Route path="/Admin">
                        <Admin/>
                    </Route>
                    <Route path="/LoginRegister">
                        <Login/>
                    </Route>
                </div>
                </Switch>


            </div>
        </Router>
    );
}

export default App;
