import Colaborador from '../Colaborador'
import './Times.css'

const Times = (props) => {
    const sectionCss = {backgroundColor: props.corSecundaria}
    const h3Css = {borderColor: props.corPrimaria}

    if(props.colaboradores.length > 0){
      return <section className="time" style={sectionCss}>
             <h3 style={h3Css}>{props.nome}</h3>
              <div className="colaboradores">
                {props.colaboradores.map(colaborador => <Colaborador 
                  colaborador={colaborador}
                />)}
              </div>
           </section>
    } else return ""
}

export default Times;