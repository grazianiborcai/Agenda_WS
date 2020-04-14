package br.com.mind5.model.action;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public interface ActionVisitorPruneV2<T extends InfoRecord> {
	public List<T> executeTransformation();
}
