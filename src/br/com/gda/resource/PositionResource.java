package br.com.gda.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.model.legacy.PositionModel;

@Path("/Position")
public class PositionResource {

	private static final String SELECT_POSITION = "/selectPosition";

	@GET
	@Path(SELECT_POSITION)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPosition(
			@QueryParam("codPosition") List<Integer> codPosition,
			@QueryParam("language") List<String> language,
			@QueryParam("name") List<String> name) {

		return new PositionModel().selectPositionResponse(codPosition,
				language, name);
	}

}
