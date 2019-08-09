package br.com.gda.json.standard;

import br.com.gda.json.JsonHelperTemplate;

public final class JstdHelper<T> extends JsonHelperTemplate<T> {

	protected JstdHelper(Class<T> tClazz) {
		super(new JstdBodyParser<T>(tClazz), new JstdResponse(), JstdHelper.class);
	}
}
