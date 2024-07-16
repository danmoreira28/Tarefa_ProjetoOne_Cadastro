package dao;

import domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements IClienteDAO {
    //utilizado o Map para salvar as informações
    private Map<Long, Cliente> map;
    //instanciando e utilizando o HashMap
    public ClienteMapDAO() {
        this.map = new HashMap<>();
    }
    //verificando se o cpf já foi cadastrado
    @Override
    public Boolean cadatrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())) {
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }
    //método usado para exclusão de cpf
    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);
        this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
    }
    //esse método pega o cliente cadastrado e altera todas as informações do mesmo cpf
    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
        if(clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
        }

    }
    //método simples para retornar os dados se o cliente estiver no map, caso não esteja retornará null
    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }
    //retorna todos os clientes com o uso do values
    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}
