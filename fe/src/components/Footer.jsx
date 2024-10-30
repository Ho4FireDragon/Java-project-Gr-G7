import { Link } from 'react-router-dom'
import { config } from '../configs'

function Footer(fixedFooter = true) {
    const footerMenus = [
        {
            title: 'Menu',
            menus: [
                { label: 'Home', path: config.routes.home },
                { label: 'About us', path: config.routes.about },
                { label: 'Frequently Asked Questions', path: config.routes.faq },
                { label: 'Our Services', path: config.routes.our_services },
                { label: 'Request Appointment', path: config.routes.appointment },
            ],
        },
        {
            title: 'Fish Types',
            menus: [
                { label: 'Goldfish', path: '/category/goldfish' },
                { label: 'Beta', path: '/category/beta' },
                { label: 'Koi', path: '/category/koi' },
            ],
        },
        {
            title: 'Fish Care',
            menus: [
                { label: 'Fish Care 101', path: '/fish-care-101' },
                { label: 'Fish Care Articles', path: '/fish-care-articles' },
                { label: 'Fish Ponds', path: '/fish-ponds' },
                { label: 'Fish Tanks', path: '/fish-tanks' },
            ],
        },
        {
            title: 'Fish Health Issues',
            menus: [
                { label: 'Fish Health 101', path: '/fish-health-101' },
                { label: 'Health Issues & Disease', path: '/health-issues-and-disease' },
                { label: 'Water Quality Articles', path: '/water-quality-articles' },
            ],
        },
        {
            title: 'About us',
            menus: [
                { label: 'Contact', path: config.routes.contact },
                { label: 'Service Areas', path: '/service-areas' },
            ],
        },
    ]

    return (
        <footer className="text-white">
            <div className="bg-primary py-8">
                <div className="container">
                    <ul className="grid grid-cols-5 gap-12">
                        {footerMenus.map((item, index) => (
                            <li key={index}>
                                <p className="text-[22px] leading-[33px] mb-[22px]">{item.title}</p>
                                <ul>
                                    {item.menus?.map((child, idx) => (
                                        <li key={idx}>
                                            <Link to={child.path} className="leading-[26px]">
                                                {child.label}
                                            </Link>
                                        </li>
                                    ))}
                                </ul>
                            </li>
                        ))}
                    </ul>
                </div>
            </div>
            <div className="bg-[url('/src/assets/images/footer.png')] h-[100px] w-full">
                <div className="container pt-4">
                    <p className="font-medium">
                        Copyright © 2024 Koi Shop | <Link to={config.routes.faq}>Privacy Policy</Link>
                    </p>
                </div>
            </div>
        </footer>
    )
}

export default Footer
