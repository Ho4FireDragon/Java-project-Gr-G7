import PropTypes from 'prop-types'
import Header from '../Header'
import Footer from '../Footer'

DefaultLayout.propTypes = {
    children: PropTypes.node.isRequired,
}

function DefaultLayout({ children }) {
    return (
        <div id="w-screen h-screen">
            <Header />
            <main>{children}</main>
            <Footer />
        </div>
    )
}

export default DefaultLayout
