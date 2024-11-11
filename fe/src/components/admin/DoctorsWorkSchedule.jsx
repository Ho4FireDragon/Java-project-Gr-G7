import "../../styles/Admin.css";

const DoctorsWorkSchedule = () => {
    const doctors = [
        { name: 'Dr. John Doe', birthDate: '1980-05-15', workingDay: 'Tuesday,Wednesday,Thursday,Friday', offDay: 'Monday' },
        { name: 'Dr. Jane Smith', birthDate: '1985-07-22', workingDay: 'Tuesday,Wednesday,Thursday,Friday', offDay: 'Monday' },
        { name: 'Dr. Emily Johnson', birthDate: '1990-01-10', workingDay: 'Tuesday,Wednesday,Thursday,Monday', offDay: 'Friday' },
        { name: 'Dr. Michael Brown', birthDate: '1983-03-25', workingDay: 'Tuesday,Wednesday,Thursday,Friday', offDay: 'Monday' },
        { name: 'Dr. Sarah Lee', birthDate: '1992-10-05', workingDay: 'Tuesday,Wednesday,Thursday,Friday', offDay: 'Monday' },
    ];

    return (
        <div className="schedule-container">
            <h2>Doctors Work Schedule</h2>
            <table className="schedule-table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Birth Date</th>
                        <th>Free days of the week</th>
                        <th>Busy Day</th>
                    </tr>
                </thead>
                <tbody>
                    {doctors.map((doctor, index) => (
                        <tr key={index}>
                            <td>{doctor.name}</td>
                            <td>{doctor.birthDate}</td>
                            <td>
                                {doctor.workingDay}
                            </td>
                            <td>
                                <span>{doctor.offDay}</span>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default DoctorsWorkSchedule;
