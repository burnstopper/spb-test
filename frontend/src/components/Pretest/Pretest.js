import React from "react"
import "./Pretest.css"
import { Button } from "react-bootstrap"

const Pretest = ({ handleClick }) => {
    return (
        <div className="quiz">
            <div className="textquiz">
                <p>
                    Диагностика иррациональных установок (SPB) - это
                    психологический тест, который используется для оценки того,
                    насколько человек склонен к иррациональному мышлению. Тест
                    был разработан Альбертом Эллисом, одним из основателей
                    рационально-эмоциональной терапии.
                </p>
                <p>
                    У людей бывают разные убеждения. Нас интересует ваше мнение
                    относительно утверждений, приведенных ниже. Пожалуйста,
                    выберите пункт, который наиболее соответствует вашему
                    отношению к данному утверждению.
                </p>
            </div>
            <Button variant="success" onClick={handleClick}>
                Начать тест
            </Button>
        </div>
    )
}

export default Pretest
