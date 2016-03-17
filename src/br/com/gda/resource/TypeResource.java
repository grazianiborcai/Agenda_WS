package br.com.gda.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.model.TypeModel;

@Path("/Type")
public class TypeResource {

	private static final String SELECT_TYPE = "/selectType";

	@GET
	@Path(SELECT_TYPE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectType(@QueryParam("codType") List<Integer> codType,
			@QueryParam("language") List<String> language,
			@QueryParam("name") List<String> name) {

		return new TypeModel()
				.selectTypeResponse(codType, language, name);
	}

}
