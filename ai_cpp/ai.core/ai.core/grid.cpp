//
//  grid.cpp
//  ai.core
//
//  Created by Viktor Kuznietsov on 7/5/17.
//  Copyright © 2017 Viktor Kuznietsov. All rights reserved.
//

#include "grid.hpp"

namespace eight_puzzle {
    
    std::vector<std::vector<int>> grid::_final_state {
        {grid::EMPTY_VALUE, 1, 2},
        {3, 4, 5},
        {6, 7, 8}
    };
    
    grid::grid(const std::vector<std::vector<int>>& state) {
        _state.resize(GRID_SIZE);

        _empty_cell = std::unique_ptr<point>(new point());
        
        for (int i = 0; i < GRID_SIZE; ++i) {
            for (int j = 0; j < GRID_SIZE; ++j) {
                _state[i].push_back(state[i][j]);

                if (EMPTY_VALUE == state[i][j]) {
                    _empty_cell->first = i;
                    _empty_cell->second = j;
                }
            }
        }
    }

    grid::grid(const grid &g) {

        for (int i = 0; i < GRID_SIZE; ++i) {
            std::__1::vector<int> item;
            for (int j = 0; j < GRID_SIZE; ++j) {
                item.push_back(g._state[i][j]);
            }

            _state.push_back(item);
        }

        _empty_cell = std::unique_ptr<point>();
        _empty_cell->first = g._empty_cell->first;
        _empty_cell->second = g._empty_cell->second;
    }
    
    bool grid::is_final_state() const {
        return match_with_final_state();
    }
    
    std::ostream& operator<<(std::ostream& os, const eight_puzzle::grid& g) {
        for (int i = 0; i < grid::GRID_SIZE; ++i) {
            for (int j = 0; j < grid::GRID_SIZE; ++j) {
                os << g._state[i][j] << " ";
            }
            
            os << std::endl;
        }
        
        return os;
    }
    
    bool grid::match_with_final_state() const {
        if (_state[0][0] != grid::EMPTY_VALUE)
            return false;
        
        for (int i = 0; i < GRID_SIZE; ++i) {
            for (int j = 0; j < GRID_SIZE; ++j) {
                if (_final_state[i][j] != _state[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }

    std::shared_ptr<grid> grid::go(const directions &direction) const {

        auto result = std::make_shared<grid>(*this);
        //int y =

        switch (direction) {
            case LEFT:
                if (can_go_left()) {
                    //result->_state[]
                }
                else {

                }
                break;
            case RIGHT:
                if (can_go_right()) {

                }
                else {

                }

                break;

            case UP:
                if (can_go_up()) {

                }
                else {

                }

                break;

            case DOWN:
                if (can_go_down()) {

                }
                else {

                }

                break;

            default:
                // todo throw exception
                break;
        }

        return result;
    }

    std::vector<directions> grid::get_directions() const {
        std::vector<directions> result;

        if (can_go_left()) {
            result.push_back(LEFT);
        }

        if (can_go_right()) {
            result.push_back(RIGHT);
        }

        if (can_go_up()) {
            result.push_back(UP);
        }

        if (can_go_down()) {
            result.push_back(DOWN);
        }

        return result;
    }

    bool grid::can_go_down() const {
        return _empty_cell->second < GRID_SIZE - 1;
    }

    bool grid::can_go_up() const {
        return _empty_cell->second > 0;
    }

    bool grid::can_go_right() const {
        return _empty_cell->first < GRID_SIZE - 1;
    }

    bool grid::can_go_left() const {
        return _empty_cell->first > 0;
    }



}
