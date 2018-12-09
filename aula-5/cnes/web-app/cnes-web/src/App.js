import React, {Component} from 'react';
import ReactTable from 'react-table';
import unidades from './unidades';
import './App.css';
import 'react-table/react-table.css';

class App extends Component {
    render() {
        const data = unidades;

        const columns = [{
            Header: 'CNES',
            accessor: "codigo"
        }, {
            Header: 'NOME',
            accessor: "razao"
        }];

        return (
            <div>
                <ReactTable
                    data={data}
                    columns={columns}
                    //pivotBy={["CNES", "NOME"]}
                    defaultPageSize={10}
                    className="-striped -highlight"
                    filterable={true}
                    getTdProps={(state, rowInfo, column, instance) => {
                        return {
                            onClick: (e, handleOriginal) => {
                                if (handleOriginal) {
                                    const url = "https://www.google.com/maps/search/?api=1&query="
                                                + rowInfo.original.latitude
                                                + ","
                                                + rowInfo.original.longitude;
                                    window.open(url, "_blank");
                                    handleOriginal();
                                }
                            }
                        };
                    }}
                />
            </div>
        );
    }
}

export default App;
