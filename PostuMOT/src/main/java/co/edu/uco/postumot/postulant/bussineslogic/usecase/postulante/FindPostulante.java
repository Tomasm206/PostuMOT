package co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante;

import java.util.List;

import co.edu.uco.postumot.common.bussineslogic.usecase.UseWithReturn;
import co.edu.uco.postumot.postulant.domain.PostulanteDomain;
import co.edu.uco.postumot.postulant.dto.PostulanteDTO;

public interface FindPostulante extends UseWithReturn<PostulanteDTO, List<PostulanteDTO>> {

}
