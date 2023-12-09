import './Top.css'
import { Link} from "react-router-dom";

const Top = () =>{

    return (
        <div className='Top'>
            <Link to="/" className="Text">
                <div className="innerText"> Main Page </div>
            </Link>
            <Link to="/User" className="Text">
                <div className="innerText"> User Page </div>
            </Link>
            <Link to="/Admin" className="Text">
                <div className="innerText"> Admin Page </div>
            </Link>
            <Link to="/LoginRegister" className="Text">
                <div className="innerText"> Login / Register </div>
            </Link>
        </div>


    );
}
export default Top;