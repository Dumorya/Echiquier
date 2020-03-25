package com.tactfactory.monprojet.services;

import java.util.List;

public interface BaseService<ENTITY,ID> {

  ENTITY save(ENTITY item);
  void delete(ENTITY item);
  ENTITY get(ID id);
  List<ENTITY> getAll();
}
