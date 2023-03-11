import React from "react"
import { Table } from "react-bootstrap"
import "./Results.css"

const Results = ({ results }) => {
    const mappingAnswers = {
        ABSENCE: "Отсутствие иррациональной установки",
        PRESENCE: "Наличие иррациональной установки",
        EXPRESSED: "Выраженное наличие иррациональной установки",
    }

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
                        <td>{results?.catastrophization}</td>
                        <td></td>
                        <td></td>
                        <td>
                            {mappingAnswers[results?.catastrophization_level]}
                        </td>
                    </tr>
                    <tr>
                        <td>Долженствование в отношении себя</td>
                        <td>{results?.self_duty}</td>
                        <td></td>
                        <td></td>
                        <td> {mappingAnswers[results?.self_duty_level]}</td>
                    </tr>
                    <tr>
                        <td>Долженствование в отношении других</td>
                        <td>{results?.others_duty}</td>
                        <td></td>
                        <td></td>
                        <td> {mappingAnswers[results?.others_duty_level]}</td>
                    </tr>
                    <tr>
                        <td>Низкая фрустрационная толерантность</td>
                        <td>{results?.low_frustration_tolerance}</td>
                        <td></td>
                        <td></td>
                        <td>
                            {
                                mappingAnswers[
                                    results?.low_frustration_tolerance_level
                                ]
                            }
                        </td>
                    </tr>
                    <tr>
                        <td>Самооценка</td>
                        <td>{results?.self_esteem}</td>
                        <td></td>
                        <td></td>
                        <td>{mappingAnswers[results?.self_esteem_level]}</td>
                    </tr>
                </tbody>
            </Table>
        </div>
    )
}

export default Results
