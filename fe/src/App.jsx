import React from 'react'
import { Routes, Route } from 'react-router-dom'
import { globalRoutes } from './routes/globalRoutes'
import DefaultLayout from './components/layouts/DefaultLayout'

function App() {
    return (
        <React.Fragment>
            <Routes>
                {globalRoutes.map((route, index) => {
                    const Path = route.path
                    const Element = route.element
                    const Layout = route.layout ?? DefaultLayout
                    return (
                        <Route
                            key={index}
                            path={Path}
                            element={
                                <Layout>
                                    <Element />
                                </Layout>
                            }
                        />
                    )
                })}
            </Routes>
        </React.Fragment>
    )
}

export default App
