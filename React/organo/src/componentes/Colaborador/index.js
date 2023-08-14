import './Colaborador.css'

const Colaborador = (props) => {
    return (<div className="colaborador">
        <div className="cabecalho">
            <img src={props.colaborador.imagem} alt={props.colaborador.nome}/>
        </div>
        <div className="rodape">
            <h4>{props.colaborador.nome}</h4>
            <h5>{props.colaborador.cargo}</h5>
        </div>
    </div>)
} 

export default Colaborador