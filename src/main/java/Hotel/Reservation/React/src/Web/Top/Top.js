import './Top.css'
import { Link} from "react-router-dom";

const Top = () =>{

    return (
        <div className='Top'>
            <Link to="/" className="Text"> Main Page </Link>
            <Link to="/User" className="Text"> User Page</Link>
            <Link to="/Hotel" className="Text"> Hotel Page</Link>
            <Link to="/Admin" className="Text"> Admin Page</Link>
            <Link to="/LoginRegister" className="Text"> Login / Register</Link>
        </div>


    );
}
export default Top;