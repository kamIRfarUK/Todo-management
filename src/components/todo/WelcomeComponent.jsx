import { Link, useParams } from 'react-router-dom'
function WelcomeComponent() {
    const {username} = useParams()
    return (
        <div className="Welcome">
        <h1> Welcome  {username} </h1>
        <h2>Manage your Todo items</h2>
        <Link to="/todos"> Go to Todos</Link>
        </div>
    );
}
export default WelcomeComponent;