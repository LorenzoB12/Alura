package br.com.alura.rh.service.promocaoCargo;

import br.com.alura.rh.exceptions.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class PromocaoCargoService {

    public void promover(Funcionario funcionario, Boolean metaBatida){
        if(Cargo.GERENTE == funcionario.getCargo()){
            throw new ValidacaoException("Um gerente não pode ser promovido!");
        }
        if(!metaBatida){
            throw new ValidacaoException("A meta do funcionário não foi batida!");
        }
        Cargo proximoCargo = funcionario.getCargo().getProximoCargo();
        funcionario.promover(proximoCargo);
    }

}
