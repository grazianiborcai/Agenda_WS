package br.com.mind5.model.checker;

import br.com.mind5.info.InfoRecord;

public interface ModelCheckerV2<T extends InfoRecord> extends  ModelCheckerV1<T> {
	public void close();
}
