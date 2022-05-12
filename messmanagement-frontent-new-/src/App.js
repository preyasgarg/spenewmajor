import { Routes, Route, BrowserRouter } from "react-router-dom";
import "./App.css";
import Login from "./Components/login";
import Foodcom from "./Components/foodcom";
import MessManager from "./Components/messmanager";
import Dashboard3 from "./Components/dashboard3";
import Todaymenu from "./Components/Todaymenu";
import NavBar from "./Components/Navbar";
import FeedBack from "./Components/feedback";
import Footermail from "./Components/footermail";
import Instruction from "./Components/Instruction";
import Messtime from "./Components/messtime";
import Foodcomnav from "./Components/foodcomnav";
import Setmesstime from "./Components/setmesstime";
import Setinstruction from "./Components/setinstruction";
import History from "./Components/history";
import Tables from "./Components/table";
import Daymenu1 from "./Components/daymenu1";

const App = () => {
  return (
    <div>
      
      <div>
        <BrowserRouter>
          <Routes>
            
            <Route path="/setmesstime" element={<Setmesstime />} />
            <Route path="/setinstruction" element={<Setinstruction />} />
            <Route path="/foodcomnav" element={<Foodcomnav/>}/>
            <Route path="/messtime" element={<Messtime />} />
            <Route path="/instruction" element={<Instruction />} />
            <Route path="/feedback" element={<FeedBack />} />
            <Route path="footermail" element={<Footermail />} />
            <Route path="/navbar" element={<NavBar />} />
            <Route path="/login" element={<Login />} />
            <Route path="/foodcom" element={<Foodcom />} />
            <Route path="/messmanager" element={<MessManager />} />
            <Route path="/dashboard3" element={<Dashboard3/>} />
            <Route path="/todaymenu" element={<Todaymenu />} />
            <Route path="/history" element={<History />} />
            <Route path="/table" element={<Tables/>} />
            <Route path="/daymenu1" element={<Daymenu1/>}/>
            
          </Routes>
        </BrowserRouter>
      </div>
    </div>
  );
};

export default App;
