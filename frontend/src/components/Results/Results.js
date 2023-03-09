import React from "react"
import { Table } from "react-bootstrap"
import "./Results.css"

const Results = ({ results }) => {
    return (
        <div className="results">
            <label>
                <h5>Результаты</h5>
            </label>
            <Table striped>
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Катастрофизация</td>
                        <td>33</td>
                        <td></td>
                        <td></td>
                        <td>Наличие иррациональной установки</td>
                    </tr>
                    <tr>
                        <td>Долженствование в отношении себя</td>
                        <td>33</td>
                        <td></td>
                        <td></td>
                        <td>Наличие иррациональной установки</td>
                    </tr>
                    <tr>
                        <td>Долженствование в отношении других</td>
                        <td>33</td>
                        <td></td>
                        <td></td>
                        <td>Наличие иррациональной установки</td>
                    </tr>
                    <tr>
                        <td>Низкая фрустрационная толерантность</td>
                        <td>33</td>
                        <td></td>
                        <td></td>
                        <td>Наличие иррациональной установки</td>
                    </tr>
                    <tr>
                        <td>Самооценка</td>
                        <td>33</td>
                        <td></td>
                        <td></td>
                        <td>Наличие иррациональной установки</td>
                    </tr>
                </tbody>
            </Table>
        </div>
    )
}

export default Results
