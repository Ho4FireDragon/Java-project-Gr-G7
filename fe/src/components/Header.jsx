import { Link } from 'react-router-dom'
import Logo from '../components/Logo'
import { config } from '../configs'
import Navbar from './Navbar'
import { Button } from '@nextui-org/react'
import { FaSignInAlt } from 'react-icons/fa' // Import icon đăng nhập

function Header() {
    const headerbar = [
        { label: 'About us', path: config.routes.about },
        { label: 'Faq', path: config.routes.faq },
        { label: 'services', path: config.routes.services },
    ]

    return (
        <header>
            <div className="container py-4 grid grid-cols-[150px_1fr] gap-3">
                <Link to={'/'}>
                    <Logo width={200} height={82} />
                </Link>
                <div style={{gap:"100px"}} className="flex items-center justify-center"> {/* Chỉnh lại justify-between */}
                    <div className="flex items-center ">
                        <ul className="flex items-center justify-start">
                            {headerbar.map((item, index) => (
                                <li key={index}>
                                    <Link to={item.path} className="text-[21px] leading-[80px] font-medium uppercase px-[21px] text-primary">
                                        {item.label}
                                    </Link>
                                </li>
                            ))}
                        </ul>
                        <Button className="text-[21px] leading-[80px] font-medium uppercase text-white px-0" color="warning">
                            <Link to={config.routes.appointment} className="px-[21px]">
                                Request Appointment
                            </Link>
                        </Button>
                    </div>
                    <Link to="/login">
                        <Button
                            color="primary"
                            className="flex items-center gap-2" // Căn giữa icon và text
                        >
                            <FaSignInAlt size={20} /> {/* Thêm icon đăng nhập */}
                            Login
                        </Button>
                    </Link>
                </div>
            </div>
            <Navbar />
        </header>
    )
}

export default Header
