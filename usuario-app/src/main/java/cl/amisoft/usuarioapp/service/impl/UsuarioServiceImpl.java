package cl.amisoft.usuarioapp.service.impl;

import cl.amisoft.usuarioapp.dao.UsuariosDao;
import cl.amisoft.usuarioapp.models.Usuarios;
import cl.amisoft.usuarioapp.service.UsuariosService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import cl.amisoft.usuarioapp.vo.UsuariosVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UsuarioServiceImpl implements UsuariosService {
    private final UsuariosDao usuariosDao;

    @Autowired
    public UsuarioServiceImpl(UsuariosDao usuariosDao) {
        this.usuariosDao = usuariosDao;
    }

    @Override
    public UsuariosVo obtener(Long id) {
        Optional<Usuarios> usuarios = usuariosDao.obtenerUsuario(id);
        if (usuarios.isPresent()) {
            return new UsuariosVo.Builder()
                    .ccrUsuario(usuarios.get().getCcrUsuario())
                    .codUsuarioCrea(usuarios.get().getCodUsuarioCrea())
                    .codUsuarioMod(usuarios.get().getCodUsuarioMod())
                    .glsFuncionarioCrea(usuarios.get().getGlsFuncionarioCrea())
                    .glsFuncionarioMod(usuarios.get().getGlsFuncionarioMod())
                    .fecCrea(usuarios.get().getFecCrea())
                    .fecMod(usuarios.get().getFecMod())
                    .glsUsername(usuarios.get().getGlsUsername())
                    .glsConcepto(usuarios.get().getGlsConcepto())
                    .fecConcepto(usuarios.get().getFecConcepto())
                    .codConcepto(usuarios.get().getCodConcepto())
                    .rut(usuarios.get().getRut())
                    .rutDiv(usuarios.get().getRutDiv())
                    .concepto(usuarios.get().getConcepto())
                    .build();
        }
        return new UsuariosVo();
    }

    @Override
    public List<UsuariosVo> listar() {
        return usuariosDao.listar().stream()
                .map(u -> new UsuariosVo.Builder()
                        .ccrUsuario(u.getCcrUsuario())
                        .codUsuarioCrea(u.getCodUsuarioCrea())
                        .codUsuarioMod(u.getCodUsuarioMod())
                        .glsFuncionarioCrea(u.getGlsFuncionarioCrea())
                        .glsFuncionarioMod(u.getGlsFuncionarioMod())
                        .fecCrea(u.getFecCrea())
                        .fecMod(u.getFecMod())
                        .glsUsername(u.getGlsUsername())
                        .glsConcepto(u.getGlsConcepto())
                        .fecConcepto(u.getFecConcepto())
                        .codConcepto(u.getCodConcepto())
                        .rut(u.getRut())
                        .rutDiv(u.getRutDiv())
                        .concepto(u.getConcepto())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public UsuariosVo agregar(UsuariosVo usuariosVo) {
        Usuarios usuario = usuariosDao.agregar(new Usuarios.Builder()
                .ccrUsuario(usuariosVo.getCcrUsuario())
                .codUsuarioCrea(usuariosVo.getCodUsuarioCrea())
                .codUsuarioMod(usuariosVo.getCodUsuarioMod())
                .glsFuncionarioCrea("Roy")//Usuario creador del registro
                .glsFuncionarioMod("")//Usuario modificador del registro
                .fecCrea(LocalDate.now())
                .fecMod(LocalDate.now())
                .glsUsername(usuariosVo.getGlsUsername())
                .glsConcepto(usuariosVo.getGlsConcepto())
                .fecConcepto(usuariosVo.getFecConcepto())
                .codConcepto(usuariosVo.getCodConcepto())
                .rut(usuariosVo.getRut())
                .rutDiv(usuariosVo.getRutDiv())
                .concepto(usuariosVo.getConcepto())
                .build());
        return new UsuariosVo.Builder()
                .ccrUsuario(usuario.getCcrUsuario())
                .codUsuarioCrea(usuario.getCodUsuarioCrea())
                .codUsuarioMod(usuario.getCodUsuarioMod())
                .glsFuncionarioCrea(usuario.getGlsFuncionarioCrea())
                .glsFuncionarioMod(usuario.getGlsFuncionarioMod())
                .fecCrea(LocalDate.now())
                .fecMod(LocalDate.now())
                .glsUsername(usuario.getGlsUsername())
                .glsConcepto(usuario.getGlsConcepto())
                .fecConcepto(usuario.getFecConcepto())
                .codConcepto(usuario.getCodConcepto())
                .rut(usuario.getRut())
                .rutDiv(usuario.getRutDiv())
                .concepto(usuario.getConcepto())
                .build();
    }

    @Override
    @Transactional
    public UsuariosVo eliminar(Long ccrUsuario) {
        Optional<Usuarios> usuario = usuariosDao.obtenerUsuario(ccrUsuario);
        if (usuario.isPresent()) {
            usuariosDao.eliminar(usuario.get());
            return new UsuariosVo.Builder()
                    .ccrUsuario(usuario.get().getCcrUsuario())
                    .codUsuarioCrea(usuario.get().getCodUsuarioCrea())
                    .codUsuarioMod(usuario.get().getCodUsuarioMod())
                    .glsFuncionarioCrea(usuario.get().getGlsFuncionarioCrea())
                    .glsFuncionarioMod(usuario.get().getGlsFuncionarioMod())
                    .fecCrea(LocalDate.now())
                    .fecMod(LocalDate.now())
                    .glsUsername(usuario.get().getGlsUsername())
                    .glsConcepto(usuario.get().getGlsConcepto())
                    .fecConcepto(usuario.get().getFecConcepto())
                    .codConcepto(usuario.get().getCodConcepto())
                    .rut(usuario.get().getRut())
                    .rutDiv(usuario.get().getRutDiv())
                    .concepto(usuario.get().getConcepto())
                    .build();
        }
        return null;
    }

    @Override
    @Transactional
    public UsuariosVo editar(Long ccrUsuario, UsuariosVo usuariosVo) {
        Usuarios usuario =  usuariosDao.editar(new Usuarios.Builder()
                .ccrUsuario(usuariosVo.getCcrUsuario())
                .codUsuarioCrea(usuariosVo.getCodUsuarioCrea())
                .codUsuarioMod(usuariosVo.getCodUsuarioMod())
                .glsFuncionarioCrea(usuariosVo.getGlsFuncionarioCrea())
                .glsFuncionarioMod("Roy")//Este es el usuario que edita
                .fecCrea(LocalDate.now())
                .fecMod(LocalDate.now())
                .glsUsername(usuariosVo.getGlsUsername())
                .glsConcepto(usuariosVo.getGlsConcepto())
                .fecConcepto(usuariosVo.getFecConcepto())
                .codConcepto(usuariosVo.getCodConcepto())
                .rut(usuariosVo.getRut())
                .rutDiv(usuariosVo.getRutDiv())
                .concepto(usuariosVo.getConcepto())
                .build());
        return new UsuariosVo.Builder()
                .ccrUsuario(usuario.getCcrUsuario())
                .codUsuarioCrea(usuario.getCodUsuarioCrea())
                .codUsuarioMod(usuario.getCodUsuarioMod())
                .glsFuncionarioCrea(usuario.getGlsFuncionarioCrea())
                .glsFuncionarioMod(usuario.getGlsFuncionarioMod())
                .fecCrea(LocalDate.now())
                .fecMod(LocalDate.now())
                .glsUsername(usuario.getGlsUsername())
                .glsConcepto(usuario.getGlsConcepto())
                .fecConcepto(usuario.getFecConcepto())
                .codConcepto(usuario.getCodConcepto())
                .rut(usuario.getRut())
                .rutDiv(usuario.getRutDiv())
                .concepto(usuario.getConcepto())
                .build();
    }
}
