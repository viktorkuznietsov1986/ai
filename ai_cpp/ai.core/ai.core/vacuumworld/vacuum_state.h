//
// Created by Viktor Kuznietsov on 8/27/17.
// Copyright (c) 2017 Viktor Kuznietsov. All rights reserved.
//

#ifndef AI_CORE_VACUUM_STATE_H
#define AI_CORE_VACUUM_STATE_H

#include "state.h"


class vacuum_state : public state {
public:
    vacuum_state(int id);
    virtual int getId() const { return _id; }

private:
    int _id;
};


#endif //AI_CORE_VACUUM_STATE_H
