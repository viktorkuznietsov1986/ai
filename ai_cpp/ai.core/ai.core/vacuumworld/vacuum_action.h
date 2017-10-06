//
// Created by Viktor Kuznietsov on 8/27/17.
// Copyright (c) 2017 Viktor Kuznietsov. All rights reserved.
//

#ifndef AI_CORE_VACUUM_ACTION_H
#define AI_CORE_VACUUM_ACTION_H

#include "action.h"

enum vacuum_actions {
    LEFT,
    RIGHT,
    SUCK
};


class vacuum_action : public action {
public:

    virtual int getId() const { return _id; }

private:
    vacuum_actions _id;
};


#endif //AI_CORE_VACUUM_ACTION_H
