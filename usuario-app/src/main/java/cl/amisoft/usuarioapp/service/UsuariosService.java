package cl.amisoft.usuarioapp.service;

import cl.amisoft.usuarioapp.vo.UsuariosVo;

import java.util.List;

public interface UsuariosService {
    UsuariosVo obtener(Long ccrUsuario);

    List<UsuariosVo> listar();

    UsuariosVo agregar(UsuariosVo usuariosVo);

    UsuariosVo eliminar(Long ccrUsuario);

    UsuariosVo editar(Long ccrUsuario, UsuariosVo usuariosVo);
}
