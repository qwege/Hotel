import './Main.css';
import DatePicker from "react-datepicker";
import React ,{useState} from "react";
import "react-datepicker/dist/react-datepicker.css";

const Main = () =>{
    const [date, setDate] = useState(new Date());
    const [startDate, setStartDate] = useState();
    const [endDate, setEndDate] = useState();

    const handleChange = (range) => {
        const [startDate, endDate] = range;
        setStartDate(startDate);
        setEndDate(endDate);
    };
    var hotels= [{Hotel:{name: 'Hotel1'}},{Hotel:{name:'Hotel2'}}]
    var renderedOutput = hotels.map(item => (
        <div key={item.Hotel.name} className="hotelContainer">
            <div className={"photoHotel"}>
            <img  src={item.Hotel.name} alt={item.Hotel.name} />
            </div>
            <div className="textHotel"> {item.Hotel.name} opis </div>
        </div>
    ));


    return (
        <div>
            <div className="dateSelector">
                <text>Choose Date:</text>
                <DatePicker className="data"
                    selected={startDate}
                    onChange={handleChange}
                    startDate={startDate}
                    endDate={endDate}
                    selectsRange
                />
            </div>
            <div className="HotelsList">
                <text>Lista Hoteli:</text>
                {renderedOutput}
            </div>
        </div>);
}
export default Main;