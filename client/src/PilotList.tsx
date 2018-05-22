import * as React from 'react';

interface Pilot {
    id: string;
    name: string;
    position: string;
    squadron: string;
}

interface PilotListProps {
}

interface PilotListState {
    pilots: Array<Pilot>;
    isLoading: boolean;
}

class PilotList extends React.Component<PilotListProps, PilotListState> {

    constructor(props: PilotListProps) {
        super(props);

        this.state = {
            pilots: [],
            isLoading: false
        };
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('http://localhost:8080/pilots/all')
            .then(response => response.json())
            .then(data => this.setState({pilots: data, isLoading: false}));
    }

    render() {
        const {pilots, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div>
                <h2>Pilot List</h2>
                {pilots.map((pilot: Pilot) =>
                    <div key={pilot.id}>
                        {pilot.name}<br/>
                        {pilot.position}<br/>
                        {pilot.squadron}<br/>
                    </div>
                )}
            </div>
        );
    }
}

export default PilotList;