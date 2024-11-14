import React from 'react'
import PropTypes from 'prop-types'

import { Navigate } from 'react-router-dom'

import { useAuthContext } from '@/context/AuthContext'

import { config } from '@/configs'
import { isObjectEmpty } from '@/utils/isObjectEmpty'

StaffGuard.propTypes = {
    children: PropTypes.node.isRequired,
}

function StaffGuard({ children }) {
    const { authUser } = useAuthContext()

    if (isObjectEmpty(authUser)) return <Navigate to={config.routes.login} replace />

    return <React.Fragment>{children}</React.Fragment>
}

export default StaffGuard
